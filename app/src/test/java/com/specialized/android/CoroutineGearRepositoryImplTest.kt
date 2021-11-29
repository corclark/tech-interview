package com.specialized.android

import io.mockk.mockk
import junit.framework.TestCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test

@ExperimentalCoroutinesApi
class CoroutineGearRepositoryImplTest : TestCase() {
    private val subject = CoroutineGearRepositoryImpl(mockk(), mockk())

    @Test
    fun getGear_emitsGear() = runBlockingTest {
        val results = subject.getGear().toList()

        assert(results.size == 1)
        val item = results[0][0]
        assert(
            item.id == "123" &&
                    item.name == "Default Item" &&
                    item.imageUrl == "https://www.realurl.com/gearItem.png"
        )
    }

    @Test
    fun getGear_emitsUpdatesFromApi() = runBlockingTest {
        val results = subject.getGear().toList()

        assert(results.size == 2)
        val item1 = results[0][0]
        assert(
            item1.id == "123" &&
                    item1.name == "Default Item" &&
                    item1.imageUrl == "https://www.realurl.com/gearItem.png"
        )
        val item2 = results[1][0]
        assert(
            item2.id == "123" &&
                    item2.name == "Updated Item Name" &&
                    item2.imageUrl == "https://www.realurl.com/gearItem.png"
        )
    }

    @Test
    fun getGear_itemAdded_emitsNewList() = runBlockingTest {
        val results = subject.getGear().toList()

        assert(results.size == 2)
        val item1 = results[0][0]
        assert(
            item1.id == "123" &&
                    item1.name == "Default Item" &&
                    item1.imageUrl == "https://www.realurl.com/gearItem.png"
        )

        val item2 = results[1][0]
        val item3 = results[1][1]
        assert(
            item2.id == "123" &&
                    item2.name == "Updated Item Name" &&
                    item2.imageUrl == "https://www.realurl.com/gearItem.png" &&
                    item3.id == "456" &&
                    item3.name == "New Item" &&
                    item3.imageUrl == "https://www.realurl.com/newGearItem.png"
        )
    }
}
