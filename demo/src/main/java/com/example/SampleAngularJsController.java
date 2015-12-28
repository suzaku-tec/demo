package com.example;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.sf.amateras.mirage.ClasspathSqlResource;
import jp.sf.amateras.mirage.SqlManager;
import jp.sf.amateras.mirage.SqlResource;
import jp.sf.amateras.mirage.session.Session;
import jp.sf.amateras.mirage.session.SessionFactory;

@Controller
public class SampleAngularJsController {

	@RequestMapping("/angular")
	String index() {
		return "angularSample";
	}

	@ResponseBody
	@RequestMapping("/angular/data")
	List<Person> getPerson() {

		Session session = SessionFactory.getSession();
		SqlManager sqlManager = session.getSqlManager();
		session.begin();
		SqlResource sql = new ClasspathSqlResource("selectPerson.sql");
		List<Person> resultList = sqlManager.getResultList(Person.class, sql);

		return resultList;
	}
}
