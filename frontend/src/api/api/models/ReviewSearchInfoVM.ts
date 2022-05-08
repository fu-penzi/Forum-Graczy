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
 * @interface ReviewSearchInfoVM
 */
export interface ReviewSearchInfoVM {
    /**
     * 
     * @type {number}
     * @memberof ReviewSearchInfoVM
     */
    id?: number;
    /**
     * 
     * @type {string}
     * @memberof ReviewSearchInfoVM
     */
    title?: string;
    /**
     * 
     * @type {string}
     * @memberof ReviewSearchInfoVM
     */
    path?: string;
    /**
     * 
     * @type {Date}
     * @memberof ReviewSearchInfoVM
     */
    publishDate?: Date;
    /**
     * 
     * @type {string}
     * @memberof ReviewSearchInfoVM
     */
    authorName?: string;
    /**
     * 
     * @type {string}
     * @memberof ReviewSearchInfoVM
     */
    introduction?: string;
    /**
     * 
     * @type {number}
     * @memberof ReviewSearchInfoVM
     */
    score?: number;
    /**
     * 
     * @type {number}
     * @memberof ReviewSearchInfoVM
     */
    popularity?: number;
}

export function ReviewSearchInfoVMFromJSON(json: any): ReviewSearchInfoVM {
    return ReviewSearchInfoVMFromJSONTyped(json, false);
}

export function ReviewSearchInfoVMFromJSONTyped(json: any, ignoreDiscriminator: boolean): ReviewSearchInfoVM {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'id': !exists(json, 'id') ? undefined : json['id'],
        'title': !exists(json, 'title') ? undefined : json['title'],
        'path': !exists(json, 'path') ? undefined : json['path'],
        'publishDate': !exists(json, 'publishDate') ? undefined : (new Date(json['publishDate'])),
        'authorName': !exists(json, 'authorName') ? undefined : json['authorName'],
        'introduction': !exists(json, 'introduction') ? undefined : json['introduction'],
        'score': !exists(json, 'score') ? undefined : json['score'],
        'popularity': !exists(json, 'popularity') ? undefined : json['popularity'],
    };
}

export function ReviewSearchInfoVMToJSON(value?: ReviewSearchInfoVM | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'id': value.id,
        'title': value.title,
        'path': value.path,
        'publishDate': value.publishDate === undefined ? undefined : (value.publishDate.toISOString()),
        'authorName': value.authorName,
        'introduction': value.introduction,
        'score': value.score,
        'popularity': value.popularity,
    };
}

