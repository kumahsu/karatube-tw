import { ApiResponse } from "./ApiResponse";

export type HealthResponse = ApiResponse<null>;

export type EchoRequest = {
  message: string;
};
export type EchoResponse = ApiResponse<string>;
