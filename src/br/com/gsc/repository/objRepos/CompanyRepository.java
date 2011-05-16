package br.com.gsc.repository.objRepos;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.gsc.model.tableMapping.Company;
import br.com.gsc.model.tableMapping.Topic;
import br.com.gsc.repository.AbsRepository;
import br.com.gsc.repository.objInterfaces.ICompanyRepository;

@Repository("CompanyRepository")
public class CompanyRepository extends AbsRepository<Company> implements ICompanyRepository {

	@Override
	public void addCompany(Company t) {
		add(t);
	}

	@Override
	public void removeCompany(Company t) {
		remove(t);
	}

	@Override
	public void updateCompany(Company t) {
		update(t);
	}

	@Override
	public List<Company> ListCompanyByID(String query, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Company findTCompanyByID(Long id) {
		return read(new Company(), id);
	}

}
