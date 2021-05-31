package com.project.stockquote.mapper;

import com.project.stockquote.model.Stock;
import com.project.stockquote.model.dto.StockDTO;
import org.springframework.stereotype.Component;

@Component
public class StockMapper {

    public Stock toEntity(StockDTO stockDTO) {
        Stock stock = new Stock();
        stock.setId(stockDTO.getId());
        stock.setName(stockDTO.getName());
        stock.setPrice(stockDTO.getPrice());
        stock.setVariation(stockDTO.getVariation());
        stock.setDate(stockDTO.getDate());
        return stock;
    }

    public StockDTO toDTO(Stock stock) {
        StockDTO stockDTO = new StockDTO();
        stockDTO.setId(stock.getId());
        stockDTO.setName(stock.getName());
        stockDTO.setPrice(stock.getPrice());
        stockDTO.setVariation(stock.getVariation());
        stockDTO.setDate(stock.getDate());
        return stockDTO;
    }
}
