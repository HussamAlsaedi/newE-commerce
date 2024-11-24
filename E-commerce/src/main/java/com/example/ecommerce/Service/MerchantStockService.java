package com.example.ecommerce.Service;

import com.example.ecommerce.Model.Merchant;
import com.example.ecommerce.Model.MerchantStock;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantStockService {

    ArrayList<MerchantStock> merchantStocks = new ArrayList<>();

    public ArrayList<MerchantStock> getMerchantStocks() {
        return merchantStocks;
    }

    public void addMerchantStocks(MerchantStock merchantStock) {
            merchantStocks.add(merchantStock);
    }

    public boolean updateMerchantStocks(int index ,MerchantStock merchantStock) {
        for (int i = 0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getId() == index) {
                merchantStocks.set(i, merchantStock);
                return true;
            }
        }
        return false;
    }

    public boolean deleteMerchantStocks(int index) {
        for (int i = 0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getId() == index) {
                merchantStocks.remove(i);
                return true;
            }
        }
        return false;
    }
}
