/**
 * 
 */
package in.sachin.cricket.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sachin.cricket.model.Accounts;
import in.sachin.cricket.repository.AccountRepository;

/**
 * @author sachingoyal
 *
 */

@Service("accountService")
public class AccountService {

	private AccountRepository accountRepository;

	@Autowired
	public AccountService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;

	}

	public void saveAccount(Accounts account) {
		accountRepository.save(account);
	}

	public Accounts findAccountByGstin(String gst, String owner) {
		return accountRepository.findByAccountOwnerAndGstin(owner, gst);
	}

	public Accounts findAccountByPan(String pan, String owner) {
		return accountRepository.findByAccountOwnerAndAccountPan(owner, pan);
	}

	public List<Accounts> fetchAccountName(String user) {
		List<Accounts> accountList = new ArrayList<Accounts>();
		Accounts accounts = new Accounts();
		accounts.setId(0);
		accounts.setAccountName("Select Account");
		accountList.add(accounts);

		List<Accounts> dbAccountList = accountRepository.findByAccountOwner(user);

		if (!dbAccountList.isEmpty()) {
			accountList.addAll(dbAccountList);
		}

		return accountList;
	}

	public List<Accounts> fetchAccountNameForInvoice(String user) {
		List<Accounts> accountList = accountRepository.findByAccountOwner(user);
		return accountList;
	}

	public Accounts findById(int id) {
		return accountRepository.findById(id);
	}
}
