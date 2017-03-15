/**
 * @file AJ, Asynchronous JavaScript
 * @author Nova
 * @version 1.0.0
 *
 * @name Mandatory Parameters
 * @param {string} url - The URL to GET from or POST to.
 * @param {string} method - Specifies if the Ajax call is "GET" or "POST".
 *
 * @name Optional Parameters
 * @param {object} urlQueries - Object data with URL data input.
 * Example: {first_name: "John", surname: "Smith"} will produce
 * "?first_name=John&surname=Smith" in the end of the URL.
 * @param {requestCallback} callback - Returns response data and status for further actions.
 * @param {boolean} isAsynchronous - true by default, allows the rest of script to run while waiting for response.
 * @param {string} contentType - Overrides server response header for content type to change the provided data format.
 *
 * @callback callback
 * @param {object|string} data - Provides a string, JSON object or XML object from the response.
 * @param {number} status - Returns HTTP status code. 200 would be success.
 * Optional arguments can be placed in any order since they are checked by value type.
 *
 * @name Functions
 * AJ.get(url, urlQueries, callback, isAsynchronous, contentType);
 * // Sends a GET request to the specified URL.
 *
 * AJ.object();
 * // Returns new XMLHttpRequest() or old ActiveXObject for compatibility.
 *
 * AJ.post(url, urlQueries, callback, isAsynchronous, contentType);
 * // Sends a POST request to the specified URL.
 *
 * AJ.presumeContent(isEnabled);
 * // true by default. Disabling this prevents outputting the callback data being the type specified by server and returns string instead regardless.
 *
 * AJ.send(url, method, urlQueries, callback, isAsynchronous, contentType);
 * // Sends a GET or POST request to the specified URL. Both AJ.get and AJ.post share this method.
 *
 *
 * @name Examples
 * AJ.get("http://www.examplesite.com/exampleMethod", function (data, status) {
 *     if (status === 200) {
 *         alert(data);
 *     } else {
 *         alert("Failed.");
 *     }
 * });
 *
 * AJ.post("http://www.examplesite.com/exampleMethod", {
 *     first_name: "John",
 *     surname: "Smith"
 * },  function (data, status) {
 *     if (status === 200) {
 *         alert(data);
 *     } else {
 *         alert("Failed.");
 *     }
 * });
 */

/*global ActiveXObject */
/*jslint indent: 4, maxerr: 50, browser: true, devel: true, plusplus: true */

var ajax = (function () {
    "use strict";
    var isPresumingContent = true,
        methods = {};

    function log(message) {
        if (console.log !== undefined) {
            console.log("AJ: " + message);
        }
    }

    methods.get = function (url) {
        var i, length = arguments.length, newArgs = [url, "GET"];
        if (typeof url !== "string") {
            log("get - URL doesn't exist or not a string.");
            return;
        }
        for (i = 1; i < length && i < 5; i++) {
            newArgs.push(arguments[i]);
        }
        // Passes URL with GET added as well as 4 possible arguments.
        methods.send.apply(this, newArgs);
    };

    methods.object = function () {
        var httpRequest, i, length, versions;

        // Current standard compatibility check.
        if (XMLHttpRequest !== undefined) {
            return new XMLHttpRequest();
        }

        // Old compatibility check.
        versions = [
            "MSXML2.XmlHttp.6.0",
            "MSXML2.XmlHttp.5.0",
            "MSXML2.XmlHttp.4.0",
            "MSXML2.XmlHttp.3.0",
            "MSXML2.XmlHttp.2.0",
            "Microsoft.XmlHttp"
        ];
        length = versions.length;
        for (i = 0; i < length; i++) {
            try {
                httpRequest = new ActiveXObject(versions[i]);
                break;
            } catch (error) {
                // Do nothing.
            }
        }
        if (!httpRequest) {
            log("Browser not supported.");
        }
        return httpRequest;
    };

    methods.post = function (url) {
        var i, length = arguments.length, newArgs = [url, "POST"];
        if (typeof url !== "string") {
            log("post - URL doesn't exist or not a string.");
            return;
        }
        for (i = 1; i < length && i < 5; i++) {
            newArgs.push(arguments[i]);
        }
        // Passes URL with POST added as well as 4 possible arguments.
        methods.send.apply(this, newArgs);
    };

    methods.presumeContent = function (isEnabled) {
        if (typeof isEnabled !== "boolean") {
            log("presumeContent - expected a boolean argument.");
            return;
        }
        isPresumingContent = isEnabled;
    };

    methods.send = function (url, method) {
        var callback, contentType, data, isAsync, // Arguments.
            i, key, // Loop indexes.
            contentHeader,
            httpRequest = methods.object(),
            length = arguments.length,
            methodCased, // Stops JSlint complaining about parameter mutation from arguments.
            queries = [];

        // Check if XMLHttpRequest is supported and mandatory vars are added.
        if (!httpRequest || typeof url !== "string" || typeof method !== "string") {
            log("send - either no AJAX object is not supported or the URL or method are incorrect.");
            return;
        }

        // Check if it's a valid method and correct case.
        methodCased = method.toUpperCase();
        if (["GET", "POST"].indexOf(methodCased) === -1) {
            log("send - GET or POST argument isn't specified in method argument.");
            return;
        }

        // Check the argument's types for optional passed parameter options.
        for (i = 2; i < length && i < 6; i++) {
            if (typeof arguments[i] === "object" && data === undefined) {
                data = arguments[i];
            } else if (typeof arguments[i] === "function" && callback === undefined) {
                callback = arguments[i];
            } else if (typeof arguments[i] === "boolean" && isAsync === undefined) {
                isAsync = arguments[i];
            } else if (typeof arguments[i] === "string" && contentType === undefined) {
                contentType = arguments[i];
            }
        }

        // Asynchronous is enabled by default.
        if (isAsync === undefined) {
            isAsync = true;
        }

        // Prepares URL data taken from data object.
        for (key in data) {
            if (data.hasOwnProperty(key)) {
                queries.push(encodeURIComponent(key) + "=" + encodeURIComponent(data[key]));
            }
        }

        httpRequest.onreadystatechange = function () {
            // Perform next step when response has been sent and verified.
            if (httpRequest.readyState === 4) {
                // Check if coder wants type to be different than suggested by server response header.
                if (typeof contentType === "string") {
                    contentType = contentType.toLowerCase();
                    if (contentType === "json") {
                        callback(JSON.parse(httpRequest.responseText), httpRequest.status);
                        return;
                    }
                    if (contentType === "xml") {
                        callback(httpRequest.responseXML, httpRequest.status);
                        return;
                    }
                    // Presume "text" if others aren't chosen.
                    callback(httpRequest.responseText, httpRequest.status);
                    return;
                }

                // Attempt letting server response header return data in the right format.
                if (isPresumingContent && httpRequest.getResponseHeader("Content-Type") !== undefined) {
                    contentHeader = httpRequest.getResponseHeader("Content-Type");
                    if (contentHeader === "application/json") {
                        callback(JSON.parse(httpRequest.responseText), httpRequest.status);
                        return;
                    }
                    if (contentHeader === "application/xml") {
                        callback(httpRequest.responseXML, httpRequest.status);
                        return;
                    }
                    // Presume "text" if server response type doesn't match any suggestions.
                    callback(httpRequest.responseText, httpRequest.status);
                    return;
                }

                // Return "text" if coder didn't request type, and presume fails or is disabled.
                callback(httpRequest.responseText, httpRequest.status);
            }
        };
        httpRequest.open(methodCased, url + (queries.length ? "?" + queries.join("&") : ""), isAsync);
        if (methodCased === "POST") {
            httpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        }
        httpRequest.send();
    };

    return methods;
}());
