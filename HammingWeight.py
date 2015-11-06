class HammingWeight(object):
    def hammingWeight(self, n):
        """
        :type n: int
        :rtype: int
        """
        i = 31
        count = 0
        while i >= 0:
            if(n/pow(2,i) == 1):
                count = count + 1
                n = n % pow(2,i)

            i=i-1

        return count
