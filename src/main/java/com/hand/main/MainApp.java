package com.hand.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hand.bean.Film;
import com.hand.daoImpl.FilmImpl;

public class MainApp {
	public static void main(String args[]){
		System.out.println("--------------");
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		System.out.println("---------------1");
		if(context!=null){
			System.out.println("context statrt");
		}
		FilmImpl filmImpl = (FilmImpl) context.getBean("filmImpl");
		Scanner input = new Scanner(System.in);
		System.out.println("请输入电影名称（title）");
		String title = input.nextLine();
		System.out.println(title+"----------");
		System.out.println("请输入电影描述（description）\n");
		String description=input.nextLine();
		System.out.println(description+"----------");
		System.out.println("请输入语言ID(language_id)\n");
		int language_id = input.nextInt();
		System.out.println(language_id+"----------");

		Film film = new Film();
		film.setTitle(title);
		film.setDescription(description);
		film.setLanguage_id(language_id);
		filmImpl.insertFilm(film);
	
		System.out.println("context stop");
	}
}
