package com.twcrone.spacemines.mine

data class MineFieldRep(
    val xDimension: Int,
    val yDimension: Int,
    val zDimension: Int,
    val mineCount: Int,
    val level: Int,
    val difficulty:String
)