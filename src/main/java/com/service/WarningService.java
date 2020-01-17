package com.service;

import com.entity.WarningHistory;
import com.mapper.WarningHistoryMapper;
import com.mapper.WarningMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarningService {

    @Autowired
    private WarningHistoryMapper warningHistoryMapper;

    @Autowired
    private WarningMapper warningMapper;

    public List<WarningHistory> selectByCardId(String cardId)
    {
        List<WarningHistory> warningHistoryList = warningHistoryMapper.selectByCardId(cardId);

        if (warningHistoryList != null)
        {
            return warningHistoryList;
        }
        return null;


    }

}
