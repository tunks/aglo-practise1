package algorithm12_20.ms;

/**
 * 
 * Given heights of player of two football teams in array A and array B respectively. Now, you have to tell if you can arrange the team for photograph with following constraint.

One Team will be standing in one row (All players of one team must be together).
Height of player of one team standing in front should be lesser than the height of player of other team standing behind him.
Follow up question to this was, what if there are N teams what would be the maximum team K you can select for photograph such that they would follow the above constraints.

I came up with the solution for 2 team but couldn't think of solution for the follow up question.
 * */
public class PlayerHeights {
/**
 * 
 * bool canArrange(vector<int> &A, vector<int> &B) {
    int teamA = 0;
    int teamB = 0;
    
    // First check if two teams can arrange photo
    for (int i = 0; i < A.size(); ++i) {
        if (A[i] < B[i]) {
            teamA++;
        } else if (B[i] < A[i]) {
            teamB++;
        }
    }
    
    // team A is in front
    if (teamA == A.size()) {
        return true;
    }
    
    // team B is in front
    return teamB == B.size();
}

int findKTeams(vector<vector<int>> teams) {
    int k = 1;
    
    // sort all teams separately by their player height
    for (int i = 0; i < teams.size(); ++i) {
        sort(teams[i].begin(), teams[i].end());
    }
    
    // sort teams based on height in increasing order
    sort(teams.begin(), teams.end());
    
    int n = (int)teams.size();
    
    vector<int> dp(n, 1);
    
    for (int i = 1; i < n; ++i) {
        // check current team with previous team
        // if they can arrange photo choose both teams
        // then current team is new previous team
        for (int j = 0; j < i; ++j) {
            if (canArrange(teams[i], teams[j])) {
                dp[i] = max(dp[i], dp[j] + 1);
                k = max(dp[i], k);
            }
        }
    }
    
    
 * */
}
