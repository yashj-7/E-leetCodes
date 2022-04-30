class Solution(object):
    def calcEquation(self, equations, values, queries):
        edges = collections.defaultdict(list)
        
        def prepare():
            for idx, (a,b) in enumerate(equations):
                val = values[idx]
                
                edges[a].append([b,val])
                edges[b].append([a,1/val])
        
        def dfs(source,sink,visited,total):
            if source == sink:
                if source in edges: return total
                else:               return -1.0
            
            if source in visited: return -1.0
            
            visited.add(source)
            
            for new_source,cost in edges[source]:
                res = dfs(new_source, sink, visited, total*cost)
                
                if res != -1: return res
            
            return -1.0
        
        prepare()
        return map(lambda (a,b): dfs(a,b,set(),1.0), queries)