package com.hand.daoImpl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.hand.DAO.FilmDAO;
import com.hand.bean.Film;

public class FilmImpl implements FilmDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void insertFilm(Film film) {
		String SQL = "insert into film(title,description,language_id) value (?,?,?)";
		jdbcTemplate.update(SQL, film.getTitle(), film.getDescription(),
				film.getLanguage_id());

	}



}
