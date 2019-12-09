package com.timpolicar.jetpacknavigationcomponenttutorial

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.math.BigDecimal

//making it parcelable
@Parcelize
data class Money(val amount: BigDecimal): Parcelable