import React, { useState } from "react";
import SelectOption from "../component/SelectOption";
import { FaArrowRightArrowLeft } from "react-icons/fa6";
function PolishNotation() {
  const [expr, setExpr] = useState("");
  const [leftType, setLeftType] = useState("Infix Notation");
  const [rightType, setRightType] = useState("Prefix Notation");

  const [converted, setConverted] = useState(false);
  const [evaluated, setEvaluated] = useState(false);
  const [checked, setChecked] = useState(false);

  const myList = [
    { name: "Infix Notation" },
    { name: "Prefix Notation" },
    { name: "Postfix Notation" },
  ];

  const handleCheck = () => {};
  const handleAlternate = () => {
    setLeftType(rightType);
    setRightType(leftType);
  };

  const handleConvert = () => {
    setConverted(`Converted version of: ${expr || "N/A"}`);
  };

  const handleEvaluate = () => {
    setEvaluated(`Evaluation result of: ${expr || "N/A"}`);
  };

  return (
    <div className="flex flex-col items-center justify-center min-h-screen bg-[#fafafa] p-6">
      <div className="w-full max-w-4xl bg-[#fafafa] border border-[#0e0e0e]/20 rounded-2xl p-6 space-y-8">
        <h2 className="text-2xl font-semibold text-[#0e0e0e] text-center">
          {leftType} to {rightType}
        </h2>

        <div className="flex flex-col md:flex-row items-center justify-center gap-6">
          {/* Left Select */}
          <SelectOption
            search={leftType}
            sortingList={myList}
            filterSearch={rightType}
            tab={"notation"}
            setSearch={setLeftType}
          />
          <div className="flex justify-center items-center my-2 ">
            <FaArrowRightArrowLeft
              className="text-[#0e0e0e] text-2xl "
              onClick={handleAlternate}
            />
          </div>

          {/* Right Select */}
          <SelectOption
            search={rightType}
            sortingList={myList}
            filterSearch={leftType}
            tab={"notation"}
            setSearch={setRightType}
          />
        </div>

        <div className="flex items-center justify-center">
          <input
            type="text"
            placeholder="Enter expression"
            value={expr}
            onChange={(e) => setExpr(e.target.value)}
            className="w-full max-w-sm p-2 border border-[#0e0e0e]/30 rounded-md bg-[#fafafa] text-[#0e0e0e] placeholder-[#0e0e0e]/50 focus:outline-none focus:border-[#0e0e0e]"
          />
        </div>

        <div className="flex flex-wrap justify-center gap-4 pt-4 border-t border-[#0e0e0e]/20">
          <button
            onClick={handleCheck}
            className="px-5 py-2 border border-[#0e0e0e] text-[#0e0e0e] rounded-md hover:bg-[#0e0e0e]/5 transition"
          >
            Check
          </button>
          {checked && (
            <button
              onClick={handleConvert}
              className="px-5 py-2 border border-[#0e0e0e] text-[#0e0e0e] rounded-md hover:bg-[#0e0e0e]/5 transition"
            >
              Convert
            </button>
          )}
          {checked && (
            <button
              onClick={handleEvaluate}
              className="px-5 py-2 border border-[#0e0e0e] text-[#0e0e0e] rounded-md hover:bg-[#0e0e0e]/5 transition"
            >
              Evaluate
            </button>
          )}
        </div>

        {/* Result Section */}
        <div className="grid grid-cols-1 md:grid-cols-2 gap-4 mt-6">
          <div className="border border-[#0e0e0e]/30 rounded-md p-3">
            <h4 className="font-semibold text-[#0e0e0e]">
              Converted Expression:
            </h4>
            <p className="mt-1 text-[#0e0e0e]">{converted}</p>
          </div>
          <div className="border border-[#0e0e0e]/30 rounded-md p-3">
            <h4 className="font-semibold text-[#0e0e0e]">Evaluation Result:</h4>
            <p className="mt-1 text-[#0e0e0e]">{evaluated}</p>
          </div>
        </div>
      </div>
    </div>
  );
}

export default PolishNotation;
