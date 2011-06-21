package com.proserus.stocks.controllers.iface;

import java.util.Collection;
import java.util.Observer;

import org.jfree.data.time.Year;

import com.proserus.stocks.bp.FilterBp;
import com.proserus.stocks.exceptions.InvalidLabelsTransactionException;
import com.proserus.stocks.exceptions.InvalidTransactionException;
import com.proserus.stocks.model.analysis.CurrencyAnalysis;
import com.proserus.stocks.model.analysis.SymbolAnalysis;
import com.proserus.stocks.model.symbols.HistoricalPrice;
import com.proserus.stocks.model.symbols.Symbol;
import com.proserus.stocks.model.transactions.Label;
import com.proserus.stocks.model.transactions.Transaction;

public interface PortfolioController {
	Transaction addTransaction(Transaction t);

	void addTransactionObserver(Observer o);

	void remove(Transaction t);

	void remove(Label label);

	Label addLabel(Label str);
	
	Collection<Label> getLabels();
	
	Year getFirstYear();
	
	void addFilterObserver(Observer o);

	Collection<Transaction> getTransactions(FilterBp filter);

	void addLabelsObserver(Observer o);

	void updateTransaction(Transaction t) throws InvalidLabelsTransactionException,
	        InvalidTransactionException;
	
	boolean updateSymbol(Symbol symbol);


	Collection<Symbol> getSymbols();

	boolean remove(Symbol s);

	Symbol addSymbol(Symbol symbol);
	Symbol getSymbol(String ticker);

	void addSymbolsObserver(Observer o);
	
	void updatePrices();

	void updateHistoricalPrices();
	
	void addAnalysisObserver(Observer o);

	void addTransactionsObserver(Observer o);

	void setCustomFilter(String custom);
	
	Collection<? extends CurrencyAnalysis> getCurrencyAnalysis(FilterBp filter);

	Collection<? extends SymbolAnalysis> getSymbolAnalysis(FilterBp filter);
	
	void update(HistoricalPrice hPrice);
	
}