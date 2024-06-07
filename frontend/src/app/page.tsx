"use client";
import React from "react";
import Adm from "./components/adm";
import Default from "./components/default";
import Center from "./components/center";

export default function Home() {
  return (
    <div className="flex bg-red-500">
      <div className="w-1/2 bg-blue-500">
        <Center />
      </div>
      <div className="w-1/2 bg-purple-500">
        <AdmContainer />
      </div>
    </div>
  );
}

function AdmContainer() {
  return (
    <div className="flex flex-col h-full">
      <div className="flex-1">
        <Adm title="Adm 1" />
      </div>
      <div className="flex-1">
        <Default title="Default 1" />
      </div>
      <div className="flex-1">
        <Adm title="Adm 2" />
      </div>
      <div className="flex-1">
        <Default title="Default 2" />
      </div>
    </div>
  );
}
