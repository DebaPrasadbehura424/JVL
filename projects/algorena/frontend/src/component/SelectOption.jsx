import React from "react";

function SelectOption({ search, setSearch, sortingList, filterSearch, tab }) {
  return (
    <select
      value={search}
      onChange={(e) => setSearch(e.target.value)}
      className="w-full p-2 border border-gray-300 rounded focus:outline-none focus:ring-2 focus:ring-blue-400"
    >
      <option value="">-- Choose a {tab} --</option>
      {sortingList
        .filter((sort) => sort.name !== filterSearch)
        .map((sort, index) => (
          <option key={index} value={sort.name}>
            {sort.name}
          </option>
        ))}
    </select>
  );
}

export default SelectOption;
