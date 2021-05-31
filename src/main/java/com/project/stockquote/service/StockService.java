package com.project.stockquote.service;

import com.project.stockquote.exceptions.BusinessException;
import com.project.stockquote.exceptions.NotFoundException;
import com.project.stockquote.mapper.StockMapper;
import com.project.stockquote.model.Stock;
import com.project.stockquote.model.dto.StockDTO;
import com.project.stockquote.repository.StockRepository;
import com.project.stockquote.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private StockMapper mapper;

    @Transactional
    public StockDTO save(StockDTO stockDTO) {
        Optional<Stock> optionalStock = stockRepository.findByNameAndDate(stockDTO.getName(), stockDTO.getDate());
        if (optionalStock.isPresent()) {
            throw new BusinessException(MessageUtils.STOCK_ALREADY_EXITS);
        }

        Stock stock = mapper.toEntity(stockDTO);
        stockRepository.save(stock);
        return mapper.toDTO(stock);
    }

    @Transactional
    public StockDTO update(StockDTO stockDTO) {
        Optional<Stock> optionalStock = stockRepository.findByStockUpdate(stockDTO.getName(), stockDTO.getDate(), stockDTO.getId());
        if (optionalStock.isPresent()) {
            throw new BusinessException(MessageUtils.STOCK_ALREADY_EXITS);
        }

        Stock stock = mapper.toEntity(stockDTO);
        stockRepository.save(stock);
        return mapper.toDTO(stock);
    }

    @Transactional(readOnly = true)
    public List<StockDTO> findAll() {
        List<Stock> resultList = stockRepository.findAll();

        return mapper.toDTO(resultList);
    }

    @Transactional(readOnly = true)
    public StockDTO findById(Long id) {
        return stockRepository.findById(id).map(mapper::toDTO).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public StockDTO delete(Long id) {
        StockDTO stockDTO = this.findById(id);
        stockRepository.deleteById(id);
        return stockDTO;
    }

    @Transactional(readOnly = true)
    public List<StockDTO> findByToday() {
        return stockRepository.findByToday(LocalDate.now()).map(mapper::toDTO).orElseThrow(NotFoundException::new);
    }
}
