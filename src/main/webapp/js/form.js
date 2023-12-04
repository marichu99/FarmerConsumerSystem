function openForm(productId) {
    document.getElementById("myForm").style.display = "flex";
    document.getElementById("hiddenId").value = productId;
}

function closeForm() {
    document.getElementById("myForm").style.display = "none";
}

// get the div elements
function rejectApprove(type,person){
    console.log(type,person)
    
}
function toggleSidebar(){
    console.log(window.innerWidth);
    // this funtion will only work on smaller devices using the code below
    if(window.innerWidth <=600){
        // get the sidebar class id
        var sidebar=document.querySelector(".navContainer");
        sidebar.style.display="none";
    }
1           } 