package com.example.tiendatenis.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.tiendatenis.model.Product

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "tiendatenis.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_PRODUCTS = "products"
        
        private const val COLUMN_ID = "id"
        private const val COLUMN_NAME = "name"
        private const val COLUMN_DESCRIPTION = "description"
        private const val COLUMN_PRICE = "price"
        private const val COLUMN_IMAGE_URL = "imageUrl"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = """
            CREATE TABLE $TABLE_PRODUCTS (
                $COLUMN_ID TEXT PRIMARY KEY,
                $COLUMN_NAME TEXT NOT NULL,
                $COLUMN_DESCRIPTION TEXT NOT NULL,
                $COLUMN_PRICE REAL NOT NULL,
                $COLUMN_IMAGE_URL TEXT NOT NULL
            )
        """.trimIndent()
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_PRODUCTS")
        onCreate(db)
    }

    // CREATE - Insertar producto
    fun insertProduct(product: Product): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_ID, product.id)
            put(COLUMN_NAME, product.name)
            put(COLUMN_DESCRIPTION, product.description)
            put(COLUMN_PRICE, product.price)
            put(COLUMN_IMAGE_URL, product.imageUrl)
        }
        val result = db.insert(TABLE_PRODUCTS, null, values)
        db.close()
        return result
    }

    // READ - Obtener todos los productos
    fun getAllProducts(): List<Product> {
        val productList = mutableListOf<Product>()
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_PRODUCTS", null)

        if (cursor.moveToFirst()) {
            do {
                val product = Product(
                    id = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ID)),
                    name = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME)),
                    description = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DESCRIPTION)),
                    price = cursor.getDouble(cursor.getColumnIndexOrThrow(COLUMN_PRICE)),
                    imageUrl = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_IMAGE_URL))
                )
                productList.add(product)
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return productList
    }

    // Insertar productos de prueba (5 productos iniciales)
    fun insertSampleProducts() {
        val sampleProducts = listOf(
            Product("1", "Tenis Star Verde", "Tenis deportivos color verde", 1599.0, ""),
            Product("2", "Tenis Star Rosa", "Tenis deportivos color rosa", 1499.0, ""),
            Product("3", "Tenis Star Rojo", "Tenis deportivos color rojo", 1599.0, ""),
            Product("4", "Tenis Star Azul", "Tenis deportivos color azul", 1699.0, ""),
            Product("5", "Tenis Star Negro", "Tenis deportivos color negro", 1799.0, "")
        )
        
        sampleProducts.forEach { insertProduct(it) }
    }
}
