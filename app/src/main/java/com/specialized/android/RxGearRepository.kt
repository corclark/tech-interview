package com.specialized.android

import io.reactivex.rxjava3.core.Observable

interface RxGearRepository {
    fun getGear(): Observable<List<GearItem>>
}

class RxGearRepositoryImpl(
    private val gearApi: GearApi,
    private val gearDao: GearDao,
) : RxGearRepository {

    override fun getGear(): Observable<List<GearItem>> {
        return Observable.empty()
    }
}