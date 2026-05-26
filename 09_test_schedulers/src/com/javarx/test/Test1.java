package com.javarx.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Test1 {

	public static void main(String[] args) throws IOException {
		Observable.interval(300, TimeUnit.MILLISECONDS)
		.subscribeOn(Schedulers.io()) // productor en IO
		//.subscribeOn(Schedulers.computation())
		.map(i -> {
			System.out.println("map1: " + i + " - " + Thread.currentThread().getName());
			return i;
		})
		.observeOn(Schedulers.io())
		.map(i -> {
			System.out.println("en cliente: " + i + " - " + Thread.currentThread().getName());
			return i;
		})
		//.observeOn(Schedulers.io())
		.subscribe(i ->
			System.out.println("subscribe: "+Thread.currentThread().getName())
		);
		System.in.read();

	}

}
