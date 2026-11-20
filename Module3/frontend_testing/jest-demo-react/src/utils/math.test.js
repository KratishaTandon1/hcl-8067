import { add, sub, mul, division } from "./math.js";
describe("Math utility testing",()=>{

    test('add two number', ()=>{
        expect(add(10,20)).toBe(30);
    })

    test('subtract two number',()=>{
        expect(sub(10,20)).toBe(-10);
    })

    test('mult two number',()=>{
        expect(mul(10,20)).toBe(200);
    })
    test('div two number',()=>{
        expect(division(10,20)).toBe(0.5);
    })
})