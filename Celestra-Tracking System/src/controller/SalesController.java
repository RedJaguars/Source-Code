package controller;

import java.sql.SQLException;
import java.util.Iterator;

import model.SalesModel;

public class SalesController extends Controller {
	
	public SalesController() {
		super();
		model = new SalesModel();
		model.register(this);
	}
	
	public Iterator<?> retrieveSalesList() throws SQLException {
		return model.getModelList();
	}

}
