package com.specialized.android

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

interface GearDao {
    fun getGear(): Observable<GearItem>
    fun addItem(item: GearItem): Completable
}

class GearDaoImpl: GearDao {
    private val data = arrayListOf(GearItem("123", "Default Item", "https://www.realurl.com/gearItem.png"))

    override fun getGear(): Observable<GearItem> {
        return Observable.empty()
    }

    override fun addItem(item: GearItem): Completable {
        TODO("Not yet implemented")
    }


}
