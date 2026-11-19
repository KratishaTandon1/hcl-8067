export const greet=(name)=>{
    return `hello, ${name}`;
}

export const greetinother=(name)=>{
    return `namaste, ${name}`;
}

export const processOrder=(data,dependency)=>{
    const paymentInfo=dependenct.processPayment(data.amount);
    return paymentInfo;

};

const processPayment=(amount)=>{
    console.log("i am real");
    return {id:123,amount};
}