package com.mockexam.Result.repository;

import com.mockexam.Result.model.OverallResult;

import java.util.Dictionary;
import java.util.Hashtable;

public class MockResultRepository {
    private final Dictionary<String, OverallResult> overallResultList;

    public MockResultRepository() {
        overallResultList = new Hashtable<>();
    }

    public OverallResult getOverallResult(String sessionKey) {
        OverallResult overallResult = overallResultList.get(sessionKey);

        if (overallResult == null) {
            overallResult = new OverallResult(sessionKey, 1, 0, 0);

            overallResultList.put(sessionKey, overallResult);
        }

        return overallResult;
    }
}
