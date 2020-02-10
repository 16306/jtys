package com.service;

import com.entity.WarningHistory;
import com.mapper.WarningHistoryMapper;
import com.mapper.WarningMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public List<WarningHistory> selectByTime(String cardId)
    {
        List<WarningHistory> warningHistoryList = warningHistoryMapper.selectByTime(cardId);

        if (null != warningHistoryList)
        {
            return warningHistoryList;
        }
        return null;
    }

    @Transactional
    public int insert(WarningHistory warningHistory)
    {
        WarningHistory last = warningHistoryMapper.getLastOne();
        if(null == last)
        {
            warningHistory.setWarningHistoryId((long)0);
            return warningHistoryMapper.insert(warningHistory);
        }
        else
        {
            warningHistory.setWarningHistoryId(last.getWarningHistoryId() + 1);
            return warningHistoryMapper.insert(warningHistory);
        }
    }

}
