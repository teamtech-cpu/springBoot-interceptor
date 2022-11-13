# springBoot-interceptor

Interceptors are useful when you need some sort of request pre-processing or response post-processing, for example - you can add missing field or header to request, or add a header to the response. Another use is request filtering - in case you want to process only requests that contain certain elements or values.

Important interceptor methods you should know about are:

preHandle() method − use this method to perform operations before sending the request to the controller. This method returns boolean, and if it returns true, your request will be processed further. 

postHandle() method − It returns void, use it for operations that should execute before sending the response to a client.

afterCompletion() method − this method will execute after the request is processed and the response is sent

 preHandle method should return boolean, so we return true here. Other two interceptor method types return void. This means that after the interceptor is executed, the application will continue request processing. We also need to register this interceptor class (I hope soon there will be some sort of annotation for this):
