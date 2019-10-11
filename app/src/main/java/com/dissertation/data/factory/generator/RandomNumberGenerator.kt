package com.dissertation.data.factory.generator

object RandomNumberGenerator {

    fun generate(numbers: List<Int>) = numbers.random()

    fun generate(numbers: IntRange) = numbers.random()

    fun generate(numbers: IntProgression) = numbers.shuffled().random()
}
