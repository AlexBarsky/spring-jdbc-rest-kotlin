package ru.barsky.cargo.util

import java.sql.ResultSet

fun ResultSet.getIntOrNull(column: String): Int? {
    val value = this.getInt(column)

    return if (this.wasNull()) null else value
}