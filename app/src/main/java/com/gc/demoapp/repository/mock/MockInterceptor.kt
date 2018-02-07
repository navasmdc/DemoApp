package com.gc.demoapp.repository.mock

import okhttp3.*
import java.nio.charset.Charset

/**
 * Created by 674756 on 05/02/2018.
 */
object MockInterceptor : Interceptor {

    var responsesMockFiles : MutableList<String> = ArrayList<String>()

    fun addResponse(file : String) = responsesMockFiles.add(file)

    override fun intercept(chain : Interceptor.Chain?) : Response {
        var body = ""
        if(!responsesMockFiles.isEmpty()){
            val inputStream = javaClass.classLoader.getResourceAsStream(responsesMockFiles.removeAt(0))
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            body = String(buffer, Charset.defaultCharset())
        }
        return Response.Builder()
                .code(200)
                .message(body)
                .request(chain?.request())
                .protocol(Protocol.HTTP_1_1)
                .body(ResponseBody.create(MediaType.parse("application/json"), body.toByteArray()))
                .addHeader("content-type", "application/json")
                .build()


    }
}