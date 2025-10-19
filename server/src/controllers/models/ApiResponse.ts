import { StatusCode } from "../../constants/StatusCode"

export type ApiResponse<T> = {
  status: StatusCode;
  message: string;
  data?: T;
};
