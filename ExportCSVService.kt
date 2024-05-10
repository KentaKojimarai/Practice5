package com.example.outputcsv

import Repository.OutputRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.io.FileWriter
import java.io.IOException

@Service
class ExportCSVService(private val outputRepository: OutputRepository) {

    @Transactional
    fun exportToCSV(filename: String) {
        val newproducts = outputRepository.findAll() // データベースから全ての商品を取得

        try {
            FileWriter(filename).use { writer ->
                // ヘッダー行を書き込む
                writer.append("Category,Name,Price (tax included),Origin\n")

                // 商品データをCSVファイルに書き込む
                newproducts.forEach { product ->
                    writer.append("${product.category},${product.name},${product.price},${product.origin}\n")
                }
            }
            println("CSVファイルにデータを書き込みました: $filename")
        } catch (e: IOException) {
            println("CSVファイルの書き込み中にエラーが発生しました: ${e.message}")
        }
    }
}