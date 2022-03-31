let a=[8,7,2,5,3,1];
target=10;
check(target,a);

function check(target,a){
    for( var i=0;i<a.length;i++)
    {
        for( var j=0;j<a.length;j++)
        if(a[i]+a[j]==target){
        console.log("pairs found",a[i],a[j])
    }
}
}