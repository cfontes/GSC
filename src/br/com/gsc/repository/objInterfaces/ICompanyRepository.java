package br.com.gsc.repository.objInterfaces;

import java.util.List;

import br.com.gsc.model.tableMapping.Company;
import br.com.gsc.model.tableMapping.Topic;

public interface ICompanyRepository {
	
	public void addCompany(Company t);
	public void removeCompany(Company t);
	public void updateCompany(Company t);
	public List<Company> ListCompanyByID(String query, Object[] params);
	public Company findTCompanyByID(Long id);
}
