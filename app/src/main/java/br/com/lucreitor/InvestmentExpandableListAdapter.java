package br.com.lucreitor;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.List;

import br.com.lucreitor.vo.Investment;

public class InvestmentExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<Investment> investments;

    public InvestmentExpandableListAdapter(Context context, List<Investment> investments) {
        this.context = context;
        this.investments = investments;
    }

    @Override
    public Object getChild(int listPosition, int expandedListPosition) {
        return this.investments.get(listPosition);
    }

    @Override
    public long getChildId(int listPosition, int expandedListPosition) {
        return expandedListPosition;
    }

    @Override
    public View getChildView(int listPosition, final int expandedListPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        final Investment investment = (Investment) getChild(listPosition, expandedListPosition);

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.investments_detail, null);
        }

        TextView capitalInvestedResultTextView = convertView.findViewById(R.id.capitalInvestedResultTextView);
        capitalInvestedResultTextView.setText(NumberFormat.getCurrencyInstance().format(investment.getResult().getCapital()));

        TextView grossProfitResultTextView = convertView.findViewById(R.id.grossProfitResultTextView);
        grossProfitResultTextView.setText(NumberFormat.getCurrencyInstance().format(investment.getResult().getGrossProfit()));

        TextView taxesResultTextView = convertView.findViewById(R.id.taxesResultTextView);
        taxesResultTextView.setText(NumberFormat.getCurrencyInstance().format(investment.getResult().getTaxes()*-1));

        TextView otherCostsResultTextView = convertView.findViewById(R.id.otherCostsResultTextView);
        otherCostsResultTextView.setText(NumberFormat.getCurrencyInstance().format(investment.getResult().getOtherCosts()*-1));

        TextView totalGrossResultTextView = convertView.findViewById(R.id.totalGrossResultTextView);
        totalGrossResultTextView.setText(NumberFormat.getCurrencyInstance().format(investment.getResult().getTotal()));

        TextView totalNetResultTextView = convertView.findViewById(R.id.totalNetResultTextView);
        totalNetResultTextView.setText(NumberFormat.getCurrencyInstance().format(investment.getResult().getTotalNet()));



        return convertView;
    }

    @Override
    public int getChildrenCount(int listPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int listPosition) {
        return this.investments.get(listPosition);
    }

    @Override
    public int getGroupCount() {
        return this.investments.size();
    }

    @Override
    public long getGroupId(int listPosition) {
        return listPosition;
    }

    @Override
    public View getGroupView(int listPosition, boolean isExpanded,View convertView, ViewGroup parent) {

        Investment investment = (Investment) getGroup(listPosition);

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.investments, null);
        }

        TextView investmentTitleTextView = convertView.findViewById(R.id.investmentTitleTextView);
        investmentTitleTextView.setTypeface(null, Typeface.BOLD);
        investmentTitleTextView.setText(investment.getDescription());

        TextView investmentResultTextView = convertView.findViewById(R.id.investmentResultTextView);
        investmentResultTextView.setTypeface(null, Typeface.BOLD);
        investmentResultTextView.setText(NumberFormat.getCurrencyInstance().format(investment.getResult().getTotalNet()));

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int listPosition, int expandedListPosition) {
        return true;
    }
}