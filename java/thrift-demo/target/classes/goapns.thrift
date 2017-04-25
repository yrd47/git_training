 namespace java me.ele.goapns.thrift
 
/**
* Types and Structures
*/

struct TMessage {
    1: required string appid,
    2: required string token,
    3: required string payload,
}

struct TApplicationPem {
    1: required string appid,
    2: required string content,
}

/**
* Exceptions
*/
enum GoApnsErrorCode {
    UNKNOWN_ERROR = 0,
    DATABASE_ERROR = 1,
    EMPTY_APPID = 2,
    EMPTY_DEVICE_TOKEN = 3,
    EMPTY_PAYLOAD = 4,
    APNS_NOT_INITIALIZED = 5,
    APNS_USER_ERROR = 6,
    APNS_UNKNOWN_ERROR = 7,
    APP_CERTIFICATE_NOT_FOUND = 10,
    ZK_ERROR = 11,
    EMPTY_PEM_CONTENT = 12,
    INVALID_PEM_CONTENT = 13,
}

exception GoApnsUserException {
    1: required GoApnsErrorCode error_code,
    2: required string error_name,
    3: optional string message,
}

exception GoApnsSystemException {
    1: required GoApnsErrorCode error_code,
    2: required string error_name,
    3: optional string message,
}

exception GoApnsUnknownException {
    1: required GoApnsErrorCode error_code,
    2: required string error_name,
    3: optional string message,
}

/**
* API
*/
service GoApnsService {
    bool ping()
        throws(1: GoApnsUserException user_exception,
               2: GoApnsSystemException system_exception,
               3: GoApnsUnknownException unknown_exception,)

    string send_message(1: TMessage message)
        throws(1: GoApnsUserException user_exception,
               2: GoApnsSystemException system_exception,
               3: GoApnsUnknownException unknown_exception,)

    // update application push certificate pem data
    void update_application_pem(1: TApplicationPem pem)
        throws(1: GoApnsUserException user_exception,
               2: GoApnsSystemException system_exception,
               3: GoApnsUnknownException unknown_exception,)

}
