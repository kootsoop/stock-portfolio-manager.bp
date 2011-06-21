package com.proserus.stocks.bp.strategies.symbols;


import java.math.BigDecimal;

import org.joda.time.DateTime;

import com.proserus.stocks.bp.FilterBp;
import com.proserus.stocks.model.analysis.Analysis;
import com.proserus.stocks.model.transactions.Transaction;
import com.proserus.stocks.model.transactions.TransactionType;

public class DividendSYM extends AbstractStrategyCumulative {
	
	@Override
	public BigDecimal getTransactionValue(Transaction t, FilterBp filter){
		//TODO Logging
		if (calculsLog.isInfoEnabled()) {
			calculsLog.info("--------------------------------------");
			calculsLog.info("Logging not completely implemented for this calcul");
		}
		BigDecimal value = BigDecimal.ZERO;
		if (t.getType().equals(TransactionType.DIVIDEND)) {
			//TODO Consider the case if  "isUseCustomFirst"
			if (!filter.isDateFiltered() || !filter.isFilteredYearAfter(new DateTime(t.getDate()))) {
				value = t.getPrice().multiply(t.getQuantity());
			}
		}
		return value;
	}
	
	@Override
    public void setAnalysisValue(Analysis analysis, BigDecimal value) {
		calculsLog.info("setDividend: " + value);
	    analysis.setDividend(value);
    }
}