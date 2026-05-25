package com.javarx.service;


import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class GeneradorService {
	Observable<Integer> numeros=Observable.just(1, 2, 3, 4)
			.concatMap(n->Observable.just(n).delay(100, TimeUnit.MILLISECONDS));
	Observable<String> cadenas=Observable.just("a", "b", "c", "d", "e", "f")
			.concatMap(n->Observable.just(n).delay(50, TimeUnit.MILLISECONDS));
	
	public Observable<String> combinarMerge(){
		return Observable.merge(numeros.map(n->n.toString()),cadenas);
	}
	
	public Observable<String> combinarZip(){
		return Observable.zip(numeros,cadenas,(n,s)->n+s);
	}
	public Observable<String> combinarLatest(){
		return Observable.combineLatest(numeros,cadenas,(n,s)->n+s);
	}
	
}
