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
 * @interface CommentUpdate
 */
export interface CommentUpdate {
    /**
     * 
     * @type {string}
     * @memberof CommentUpdate
     */
    comment?: string;
}

export function CommentUpdateFromJSON(json: any): CommentUpdate {
    return CommentUpdateFromJSONTyped(json, false);
}

export function CommentUpdateFromJSONTyped(json: any, ignoreDiscriminator: boolean): CommentUpdate {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'comment': !exists(json, 'comment') ? undefined : json['comment'],
    };
}

export function CommentUpdateToJSON(value?: CommentUpdate | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'comment': value.comment,
    };
}

