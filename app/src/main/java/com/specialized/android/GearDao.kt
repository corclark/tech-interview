package com.specialized.android

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

interface GearDao {
    fun getGear(): Flow<GearItem>
    fun addItem(item: GearItem): Flow<Boolean>
}

class GearDaoImpl : GearDao {
    private val data =
        arrayListOf(GearItem("123", "Default Item", "https://www.realurl.com/gearItem.png"))

    override fun getGear(): Flow<GearItem> {
        return flowOf()
    }

    override fun addItem(item: GearItem): Flow<Boolean> {
        TODO("Not yet implemented")
    }


}
