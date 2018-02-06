package com.gc.demoapp.repository.mock

import com.gc.demoapp.repository.*
import com.gc.demoapp.repository.remote.Repository

/**
 * Created by 674756 on 05/02/2018.
 */
class MockRepository(api : Api, var mockInterceptor : MockInterceptor) : Repository(api) {}