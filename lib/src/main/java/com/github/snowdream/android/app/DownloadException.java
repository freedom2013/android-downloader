/*******************************************************************************
 * Copyright (C) 2013 Snowdream Mobile
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/

package com.github.snowdream.android.app;


/**
 * @author snowdream <yanghui1986527@gmail.com>
 * @date Sep 29, 2013
 * @version v1.0
 */
public class DownloadException extends Exception {
    private int code = UNKNOWN;

    /** serialVersionUID **/
    private static final long serialVersionUID = -3804737584048978515L;

    /**
     * Unknown Error
     */
    public static final int UNKNOWN = 0;

    /**
     * The task is not valid.
     */
    public static final int DOWNLOAD_TASK_NOT_VALID = 1;

    /**
     * The context is NULL.
     */
    public static final int CONTEXT_NOT_VALID = 2;
    
    /**
     * the operation is not valid.
     */
    public static final int OPERATION_NOT_VALID = 10;
    
    /**
     * The task failed.
     */
    public static final int DOWNLOAD_TASK_FAILED = 11;

    public DownloadException(){
        super(generateMessageFromCode(UNKNOWN));
        this.code = UNKNOWN;
    }

    public DownloadException(int code) {
        super(generateMessageFromCode(code));
        this.code = code;
    }

    public DownloadException(int code,String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Generage the error message with the code
     * @param code
     */
    private static String generateMessageFromCode(int code){
        String message = null;

        switch (code){
            case DOWNLOAD_TASK_NOT_VALID:
                message = "The DownloadTask is null or not valid!";
                break;
            case CONTEXT_NOT_VALID:
                message = "The Context is null or not valid!";
                break;
            case OPERATION_NOT_VALID:
                message = "The operation is not allowed!";
                break;
            case DOWNLOAD_TASK_FAILED:
                message = "The Download Task is failed!";
                break;
            case UNKNOWN:
            default:
                    message = "Unknown Error!";
                break;
        }
        return message;
    }
}
