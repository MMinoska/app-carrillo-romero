package com.example.app_carrillo_romero.firebase.cloudfirestore

import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.ktx.Firebase
import com.google.firebase.firestore.ktx.firestore
import java.security.cert.CertPath
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

object CloudFileStoreWrapper {
    suspend fun replace(collectionPath: String, documentPath: String, map: MutableMap<String, Any>): Void{
        return suspendCoroutine { continuation ->
            Firebase.firestore.collection(collectionPath).document(documentPath).set(map)
                .addOnSuccessListener {
                    continuation.resume(it)
                }
                .addOnFailureListener{
                    continuation.resumeWithException(it)
                }
        }
    }
    suspend fun select(collectionPath: String,conditionMap: MutableMap<String,Any>?=null, limit:Long): QuerySnapshot{
        return suspendCoroutine { continuation ->
            val collectionReference =Firebase.firestore.collection(collectionPath)

            //Select one default
            var query = collectionReference.limit(limit)

            conditionMap?.let{
                it.forEach { map->
                    query = collectionReference.whereEqualTo(map.key, map.value)
                }
            }
            query.get()
                .addOnSuccessListener {
                    continuation.resume(it)
                }
                .addOnFailureListener{
                    continuation.resumeWithException(it)
                }
        }
    }
}