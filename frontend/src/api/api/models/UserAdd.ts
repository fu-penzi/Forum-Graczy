/* tslint:disable */
/* eslint-disable */
/**
 * OpenAPI definition
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: v0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { exists, mapValues } from '../runtime';
/**
 * 
 * @export
 * @interface UserAdd
 */
export interface UserAdd {
    /**
     * 
     * @type {string}
     * @memberof UserAdd
     */
    username?: string;
    /**
     * 
     * @type {string}
     * @memberof UserAdd
     */
    email?: string;
    /**
     * 
     * @type {string}
     * @memberof UserAdd
     */
    password?: string;
}

export function UserAddFromJSON(json: any): UserAdd {
    return UserAddFromJSONTyped(json, false);
}

export function UserAddFromJSONTyped(json: any, ignoreDiscriminator: boolean): UserAdd {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'username': !exists(json, 'username') ? undefined : json['username'],
        'email': !exists(json, 'email') ? undefined : json['email'],
        'password': !exists(json, 'password') ? undefined : json['password'],
    };
}

export function UserAddToJSON(value?: UserAdd | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'username': value.username,
        'email': value.email,
        'password': value.password,
    };
}
