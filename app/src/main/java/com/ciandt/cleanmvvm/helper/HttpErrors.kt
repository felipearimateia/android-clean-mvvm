package com.ciandt.cleanmvvm.helper

sealed class HttpErrors: Throwable() {
    data class ResourceForbidden(val code: Int, val resource: Int? = null) : HttpErrors()
    data class ResourceNotFound(val code: Int, val resource: Int? = null) : HttpErrors()
    data class InternalServerError(val code: Int, val resource: Int? = null) : HttpErrors()
    data class BadGateWay(val code: Int, val resource: Int? = null) : HttpErrors()
    data class ResourceRemoved(val code: Int, val resource: Int? = null) : HttpErrors()
    data class RemovedResourceFound(val code: Int, val resource: Int? = null) : HttpErrors()
    data class GenericError(val code: Int, val resource: Int? = null): HttpErrors()
}

fun handleHttpError(code: Int): HttpErrors {
    return when (code) {
        403 -> HttpErrors.ResourceForbidden(code)
        404 -> HttpErrors.ResourceNotFound(code)
        500 -> HttpErrors.InternalServerError(code)
        502 -> HttpErrors.BadGateWay(code)
        301 -> HttpErrors.ResourceRemoved(code)
        302 -> HttpErrors.RemovedResourceFound(code)
        else -> HttpErrors.GenericError(code)
    }
}
