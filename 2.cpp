 int maxDistance(int arr[], int n)
    {
        unordered_map<int,vector<int>> m;
        for(int i=0; i<n; i++)
        {
            if(m.find(arr[i])==m.end())
            {m.insert(arr[i],{i});}
            else
            {
                vector<int> v=m.find(arr[i])-> second;
                v.push_back(i);
                m.find(arr[i])->second = v;
            }
        }                                                      // map assign as int, vector == element, index of occuring
        
        vector<int> vec;
        for(auto it=m.begin(); it!=m.end(); it++)
        {
            vector<int> a;
            a=it-> second;
            sort(a.begin(), a.end());
            int k=a.end()-a.begin();                        // max-min after sorting 
            vec.push_back(k);                               // then save all the difference in a vector vec
        }
        sort(vec.begin(), vec.end());                       // then i sort vec to get the max element 
        int d=m.size();
        int p = vec[d];                                     // max element to return
        return p;
    }
