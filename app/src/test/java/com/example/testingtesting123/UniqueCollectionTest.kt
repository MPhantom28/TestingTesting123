package com.example.testingtesting123

import org.junit.Before
import org.junit.Test

class UniqueCollectionTest {

    lateinit var collection: UniqueCollection

    @Before
    fun setUp() {
        collection = UniqueCollection()
    }


    // TODO 1: Write a test to ensure items can be added to the collection
    @Test
    fun addAnItem() {
        val initialSize = collection.size()
        collection.addItem(Item("Test Item"))
        val finalSize = collection.size()

        assert(finalSize == initialSize + 1) {"Item should be added to collection"}

    }

    // TODO 2: Write a test to ensure that only unique items can be added to the collection
    // Uniqueness is determined by the Item.name property, which is set via the constructor
    @Test
    fun addUniqueItem() {
        collection.addItem(Item("Apple"))
        val sizeAfterFirstAdd = collection.size()

        collection.addItem(Item("Apple"))
        val sizeAfterDuplicate = collection.size()

        collection.addItem(Item("Orange"))
        val sizeAfterDifferentItem = collection.size()

        assert(sizeAfterFirstAdd == 1) { "First item should be added" }
        assert(sizeAfterDuplicate == 1) { "Duplicate item should not be added" }
        assert(sizeAfterDifferentItem == 2) { "Different item should be added" }


    }

    // Test Driven Development (TDD) test - complete specified function so that this test passes
    @Test
    fun clearAllItems() {
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        val originalSize = collection.size()
        collection.clear()
        val newSize = collection.size();

        assert(originalSize == 2 && newSize == 0) {"Items not cleared"}
    }
}