package com.specialized.android

import io.mockk.mockk
import junit.framework.TestCase
import org.junit.Test

class RxGearRepositoryImplTest : TestCase() {
    val subject = RxGearRepositoryImpl(mockk(), mockk())

    @Test
    fun getGear_emitsGear() {
        val results = subject.getGear().test()

        results.assertValueCount(1)
        results.assertValueAt(0) {
            val item = it.first()
            it.size == 1 &&
                    item.id == "123" &&
                    item.name == "Default Item" &&
                    item.imageUrl == "https://www.realurl.com/gearItem.png"
        }
    }

    @Test
    fun getGear_emitsUpdatesFromApi() {
        val results = subject.getGear().test()

        results.assertValueCount(2)
        results.assertValueAt(0) {
            val item = it.first()
            it.size == 1 &&
                    item.id == "123" &&
                    item.name == "Default Item" &&
                    item.imageUrl == "https://www.realurl.com/gearItem.png"
        }
        results.assertValueAt(1) {
            val item = it.first()
            it.size == 1 &&
                    item.id == "123" &&
                    item.name == "Updated Item Name" &&
                    item.imageUrl == "https://www.realurl.com/gearItem.png"
        }
    }

    @Test
    fun getGear_itemAdded_emitsNewList() {
        val results = subject.getGear().test()

        results.assertValueCount(2)
        results.assertValueAt(0) {
            val item = it.first()
            it.size == 1 &&
                    item.id == "123" &&
                    item.name == "Default Item" &&
                    item.imageUrl == "https://www.realurl.com/gearItem.png"
        }
        results.assertValueAt(1) {
            val first = it.first()
            val second = it[1]
            it.size == 2 &&
                    first.id == "123" &&
                    first.name == "Updated Item Name" &&
                    first.imageUrl == "https://www.realurl.com/gearItem.png" &&
                    second.id == "456" &&
                    second.name == "New Item" &&
                    second.imageUrl == "https://www.realurl.com/newGearItem.png"
        }
    }
}