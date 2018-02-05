package com.gc.navigationinjector

import kotlin.reflect.KClass

fun KClass<*>.isDefault() = this.simpleName == "Default"